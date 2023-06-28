package game.policy.policies.Keys;

import core.render.ViewPort;
import game.policy.KeyPolicy;

public class LEFT extends KeyPolicy {
    @Override
    protected void press() {
        var mario = ViewPort.getInstance().getLockedElement();
        mario.setSpeedX(-2);
        mario.getManager().setMirrored(true);
        mario.getManager().restart();
    }

    @Override
    protected void release() {
        var mario = ViewPort.getInstance().getLockedElement();
        mario.setSpeedX(0);
        mario.getManager().pause();
        mario.getManager().resetState();
    }

    @Override
    public boolean isEnforceable(int keyCode) {
        return keyCode == LEFT;
    }
}
