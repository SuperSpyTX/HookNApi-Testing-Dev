import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.*;
public class Main
{
  public static HashMap plugins = new HashMap();
  public static HashMap toggles = new HashMap();

  public static void main(String[] paramArrayOfString) {
    System.out.println("HookNAPI Minecraft Client");
    File directory = new File(".");
    File[] filesList = directory.listFiles();
    LinkedList localLinkedList = new LinkedList(Arrays.asList(filesList));
    Iterator<File> itr = localLinkedList.iterator();

    while (itr.hasNext()) {
	File file = itr.next();
      if (!file.getName().endsWith(".class") || file.getName().contains("Main") || file.getName().contains("BaseMod")) {
        continue;
	}
      try
      {
        Class clazz = Class.forName(file.getName().replace(".class", ""));
        Method bass = clazz.getMethod("callMod");
        BaseMod b = (BaseMod) bass.invoke(null);
        String cmd = b.getCmd();
        plugins.put(cmd, clazz);
      } catch (Exception localException1) {
        localException1.printStackTrace();
      }
    }
    Scanner in = new Scanner(System.in);
    boolean exited = false;

    while (!exited) {
      boolean flag = false;
      System.out.println("Hook N API Console V1.0 - .SuPaH sPii");
      String str = in.nextLine();
      String cmds = str.split(" ")[0];
      if (cmds.contains("exit")) {
        flag = true;
       	exited = true;
      }

      if (plugins.containsKey(cmds)) {
        try {
          Class clazz = (Class)plugins.get(str);
          Method bass = clazz.getMethod("callMod");
          BaseMod b = (BaseMod) bass.invoke(null);
          String[] arg = str.replace(b.getCmd() + " ", "").split(" ");
          if (arg.equals(b.getCmd())) {
            b.run(new String[0]);
         } else {
            b.run(arg);
          }
        } catch (Exception localException2) {
          System.out.println("Command execution failed!");
          localException2.printStackTrace();
          flag = true;
        }
      }
      if (cmds.startsWith("help")) {
        try {
          String helparg = str.split(" ")[1];

          if (plugins.containsKey(helparg)) {
            Class clazz = (Class)plugins.get(helparg);
          Method bass = clazz.getMethod("callMod");
          BaseMod b = (BaseMod) bass.invoke(null);
            String str3 = "";
            try {
              if (b.getUsage() != null)
                str3 = "Usage: " + b.getCmd() + " [" + b.getUsage() + "]";
              else
                str3 = "Usage: Implement me!";
            }
            catch (Exception localException4) {
              str3 = "Usage: Implement me!";
            }
            String str4 = "";
            try {
              if (b.getHelp() != null)
                str4 = (b.getHelp());
              else
                str4 = "Implement me!";
            }
            catch (Exception localException5) {
              str4 = "Implement me!";
            }
            System.out.println(str3);
            System.out.println(str4);
          }
          else {
            System.out.println("Could not find mod help!");
          }
        } catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
          Iterator it = plugins.entrySet().iterator();
          while (it.hasNext()) {
             Map.Entry pairs = (Map.Entry)it.next();
            System.out.println(pairs.getKey());
          }
        } catch (Exception localException3) {
          System.out.println("Command execution failed!");
          localException3.printStackTrace();
        }

       flag = true;
      }

      if (!flag && (!cmds.equals("")))
        System.out.println("Invalid Command!");
    }
  }
}