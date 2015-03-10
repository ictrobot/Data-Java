package ethanjones.data;

public interface DataParser {

  public DataGroup write();

  public void read(DataGroup dataGroup);
}