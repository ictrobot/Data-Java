package ethanjones.data.other;

import ethanjones.data.Data;

public interface DataParser<T extends Data> {

  public T write();

  public void read(T data);
}
