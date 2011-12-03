public abstract class BaseMod
{
  public abstract String getCmd();

  public abstract String getHelp();

  public abstract String getUsage();

  public abstract String getKey();

  public abstract void run(String[] args);
}