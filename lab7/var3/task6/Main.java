package lab7.var3.task6;

public class Main {
  public static void main(String[] args) {
    System.out.println("\n########## Initialize ##########");
    String sentence = "Как почти все наши кладбища, оно являет вид печальный: окружающие его канавы давно заросли; серые деревянные кресты поникли и гниют под своими когда-то крашеными крышами; каменные плиты все сдвинуты, словно кто их подталкивает снизу; два-три ощипанных деревца едва дают скудную тень; овцы безвозбранно бродят по могилам.";

    System.out.println("\n########## Replace words ##########");
    String result = sentence.replaceAll("(\\p{L}+)( )(\\p{L}+)(\\p{Punct})", "$1$4$2$3").replaceAll("(.+?)( )(\\p{L}+)$", "$3$2$1");
    System.out.println(result);
  }
}
