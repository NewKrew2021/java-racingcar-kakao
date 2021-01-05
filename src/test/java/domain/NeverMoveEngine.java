package domain;

public class NeverMoveEngine implements Engine {
    @Override
    public boolean canMove() {
        return false;
    }
}
