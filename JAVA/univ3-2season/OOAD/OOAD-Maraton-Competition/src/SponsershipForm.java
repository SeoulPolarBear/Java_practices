import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SponsershipForm{

int mSponsorCount;
List<String> mSponsors;
List<Integer> mAmounts;

public SponsershipForm(){

mSponsorCount = 0;
mSponsors = new ArrayList<String>();
mAmounts = new ArrayList<Integer>();
}
public void addSponsor(String pName, int pAmount){
mSponsors.add(pName);
mAmounts.add(pAmount);
mSponsorCount += pAmount;
}

public int SponsorTotalCount() {
	return mSponsorCount;
}

void printCollectionList() {

System.out.println("Sponsor List");
String nextItem;
Integer nextAmt;
Iterator it1 = mSponsors.iterator();
Iterator it2 = mAmounts.iterator();
while (it1.hasNext() && it2.hasNext())
{
nextItem = (String)it1.next();
nextAmt = (Integer)it2.next();
System.out.println(nextItem + " " + nextAmt);
    }
System.out.println(" Total: " + mSponsorCount);
}
}
