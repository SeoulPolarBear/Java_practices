public class Professional extends Runner {

int mWorldRanking;

public Professional( int pNumber, int pWorldRanking) {
super(pNumber);
 this.mWorldRanking = pWorldRanking;
     }

@Override
public String toString() {
return super.toString() + "(" + mWorldRanking + ")";
         }
@Override
public void finish(int hours, int mins, int secs) {
super.finish(hours, mins, secs);

     }

}


