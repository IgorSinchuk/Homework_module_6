
abstract class MusicalInstrument {
    public abstract String getType();

    @Override
    public String toString() {
        return getType();

    }
}
