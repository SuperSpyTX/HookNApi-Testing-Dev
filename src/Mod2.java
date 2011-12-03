import java.io.PrintStream;

public class Mod2 extends BaseMod
{
  public static Mod2 mod = new Mod2();

  public static Mod2 callMod() {
    return mod;
  }

  public String getCmd() {
    return "mod2";
  }

  public String getKey() {
    return null;
  }

  public String getHelp() {
    return "Runs the most basic mod out there... Mod2";
  }

  public String getUsage() {
    return "string argument here.";
  }

  public void run(String[] args) {
    System.out.println("LOL At: " + args[0]);
  }
}