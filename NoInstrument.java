
public class NoInstrument extends Exception{
    private String noInstrument;

    public NoInstrument(String noInstrument) {
        this.noInstrument = noInstrument + "\n";
    }

    @Override
    public String getMessage() {
        return noInstrument;
    }
}

