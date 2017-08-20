package il.co.electriccollege.triathlon.animals;

/**
 * Created by Comp8 on 15/08/17.
 */
public class SpeedException extends Throwable {
   int cProp;
    public SpeedException(String s, int cProposal) {
        super(s);
        this.cProp = cProposal;
    }
    public int getcProp(){
        return cProp;
    }
}
