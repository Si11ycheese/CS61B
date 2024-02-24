import synthesizer.GuitarString;
import edu.princeton.cs.algs4.StdAudio;

public class GuitarHero {
    private static double frequency;
    private  static final  String  keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void main(String[] args){
        GuitarString []keys=new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            keys[i] = new synthesizer.GuitarString(440.0 * Math.pow(2, (i - 24) / 12));
        }
        while(true){

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int i=keyboard.indexOf(key);
                if (i < 0){
                    System.out.println("please enter valid key : " + keyboard);
                    continue;
                }
                    keys[i].pluck();
            }
            double sample=0;
            for(GuitarString string:keys){
                sample+= string.sample();
            }
            StdAudio.play(sample);
            for(GuitarString string:keys){
                string.tic();
            }


        }

    }


}
