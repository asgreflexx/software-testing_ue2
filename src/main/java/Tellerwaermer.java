public class Tellerwaermer {

    public void init(int maxSize){
        this.maxSize = maxSize;
        teller = new ArrayList<>();
    }

    public void push() throws NotInitializedException, MaxSizeReachedException {
        if(teller != null) {
            if(teller.size() < maxSize) {
                teller.add(1);
            } else {
                throw new MaxSizeReachedException(TELLERSTAPEL_IS_FULL);
            }

        } else {
            throw new NotInitializedException(TELLERSTAPEL_NOT_INITALISED);
        }
    }

}
