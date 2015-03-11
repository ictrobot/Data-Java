package ethanjones.data;

import java.io.*;

public final class Data {

  public static Object input(DataInput input) throws IOException {
    return DataInterpreter.get(input.readByte()).input(input);
  }

  public static void output(Object obj, DataOutput output) throws IOException {
    DataInterpreter interpreter = DataInterpreter.get(obj.getClass());
    output.write(interpreter.id());
    interpreter.output(obj, output);
  }

  // Byte Array
  public static Object input(byte[] bytes) throws IOException {
    return input(new DataInputStream(new ByteArrayInputStream(bytes)));
  }

  public static byte[] output(Object obj) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    output(obj, new DataOutputStream(byteArrayOutputStream));
    return byteArrayOutputStream.toByteArray();
  }

  // File
  public static Object input(File file) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(file);

    try {
      return input(new DataInputStream(fileInputStream));
    } finally {
      fileInputStream.close();
    }
  }

  public static void output(Object obj, File file) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(file);

    try {
      output(obj, new DataOutputStream(fileOutputStream));
    } finally {
      fileOutputStream.close();
    }
  }
}