package game.animations.items;

import core.objects.DynamicElement;
import core.objects.ElementManager;
import core.render.ViewPort;

public class ItemsThread extends ElementManager {
    private final static int UP = -5;
    private final static int RIGHT = 1;
    public ItemsThread(DynamicElement element) {
        super(element, new SpriteRotator(element));
    }

    protected record SpriteRotator(DynamicElement element) implements Runnable {
        @Override
            public void run() {
                try {
                    element.setSpeedY(UP);
                    Thread.sleep(5000);
                    element.setSpeedY(0);
                    if (!element.getType().equals("Flower")) {
                        Thread.sleep(3000);
                        element.setSpeedX(RIGHT);
                        if (element.getType().equals("Star")) {
                            while (ViewPort.getInstance().inView(element)) {
                                if (element.getSpeedY() == 0) {
                                    element.setY(element.getY() - 5);
                                    element.setSpeedY(UP);
                                    sleep(3000);
                                } else
                                    Thread.sleep(100);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                element.getManager().kill(); // TODO : resolve null pointer exception error
            }
        }
}