public class Amateur extends Runner{

SponsershipForm mSponsorshipForm;

public Amateur( int pNumber, SponsershipForm pSponsorshipForm) {
super(pNumber);
this.mSponsorshipForm = pSponsorshipForm;
}
@Override
public void finish( int hours, int mins, int secs)
{
   super.finish(hours, mins, secs);
   mSponsorshipForm.printCollectionList();
}

public int SponsorTotal() {
	return mSponsorshipForm.SponsorTotalCount();
}

}
