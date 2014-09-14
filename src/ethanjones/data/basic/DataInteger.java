package ethanjones.data.basic;

import ethanjones.data.DataBasic;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataInteger extends DataBasic<DataInteger, Integer> {

  public DataInteger() {
    this(0);
  }

  public DataInteger(Integer i) {
    super(4, i);
  }

  @Override
  public void write(DataOutput output) throws IOException {
    output.writeInt(obj);
  }

  @Override
  public void read(DataInput input) throws IOException {
    obj = input.readInt();
  }
}
