package ethanjones.data.basic;

import ethanjones.data.DataBasic;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataLong extends DataBasic<DataLong, Long> {

  public DataLong() {
    this(0l);
  }

  public DataLong(Long l) {
    super(5, l);
  }

  @Override
  public void write(DataOutput output) throws IOException {
    output.writeLong(obj);
  }

  @Override
  public void read(DataInput input) throws IOException {
    obj = input.readLong();
  }
}
