public class ExampleMod extends BaseMod
{
  public static ExampleMod mod = new ExampleMod();

  public static ExampleMod callMod() {
    return mod;
  }

  public String getCmd() {
    return "examplemod";
  }

  public String getKey() {
    return null;
  }

  public String getHelp() {
    return null;
  }

  public String getUsage() {
    return null;
  }

  public void run(String[] args)
  {
  }
}