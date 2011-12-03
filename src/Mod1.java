import java.io.PrintStream;

public class Mod1 extends BaseMod
{
  public static Mod1 mod = new Mod1();

  public static Mod1 callMod() {
    return mod;
  }

  public String getCmd() {
    return "mod1";
  }

  public String getKey() {
    return null;
  }

  public String getHelp() {
    return "First Mod here on HookNAPI";
  }

  public String getUsage() {
    return null;
  }

  public void run(String[] args) {
    System.out.println("uMad?");
  }
}