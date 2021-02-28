package com.rogeop.lambda.core.iterateparent;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Robert Pepersack
 */
public class IterateParents {

    /**
     * Iterates parents of a specified Component and finds the first instance of a
     * specified Component subclass
     */
    public PanelA findFirstPanelAParent(Component component) {
        PanelA panelA = Stream.iterate(component, Component::getParent).filter(Objects::nonNull)
                .filter(c -> c instanceof PanelA).map(PanelA.class::cast).findFirst().get();
        return panelA;
    }

    public static void main(String[] args) {
        Frame frame = new Frame("frame");
        PanelA panelA1 = new PanelA("panelA1", frame);
        PanelA panelA2 = new PanelA("panelA2", panelA1);
        PanelB panelB = new PanelB("panelB", panelA2);
        PanelC panelC = new PanelC("panelC", panelB);
        Text text = new Text("text", panelC);

        PanelA parent = new IterateParents().findFirstPanelAParent(text);
        System.out.println("parent: " + parent.getName());
    }

}