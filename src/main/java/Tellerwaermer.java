public class Tellerwaermer {

    public void init(int maxSize){
        this.maxSize = maxSize;
        teller = new ArrayList<Integer>();
    }

    public void push() throws NotInitializedException, MaxSizeReachedException {
        if(teller != null) {
            if(teller.size() < maxSize) {
                teller.add(1);
            } else {
                throw new MaxSizeReachedException("Tellerstapel ist voll!");
            }

        } else {
            throw new NotInitializedException("Tellerstapel not initialized");
        }
    }

}
