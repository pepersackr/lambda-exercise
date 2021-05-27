package com.rogeop.lambda.core.iterateparent;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Robert Pepersack
 */
public class IterateParents {

    /**
     * Iterates parents of a specified Component and finds the first instance of a
     * PanelA
     *
     * @param component the component for which the first PanelA parent will be
     *                  found
     */
    public PanelA getFirstPanelAParent(Component component) {
        PanelA panelA = Stream.iterate(component, Component::getParent).filter(Objects::nonNull)
                .filter(PanelA.class::isInstance).findFirst().map(PanelA.class::cast).get();
        return panelA;
    }

    /**
     * Iterates parents of a specified Component and finds the last instance of a
     * PanelC
     *
     * @param component the component for which the last PanelC parent will be found
     */
    public PanelC getLastPanelCParent(Component component) {
        PanelC panelC = Stream.iterate(component, Component::getParent).filter(Objects::nonNull)
                .filter(PanelC.class::isInstance).reduce((first, second) -> second).map(PanelC.class::cast)
                .orElse(null);
        return panelC;
    }

    public static void main(String[] args) {
        Frame frame = new Frame("frame");
        PanelC panelC1 = new PanelC("panelC1", frame);
        PanelA panelA1 = new PanelA("panelA1", panelC1);
        PanelA panelA2 = new PanelA("panelA2", panelA1);
        PanelB panelB = new PanelB("panelB", panelA2);
        PanelC panelC2 = new PanelC("panelC2", panelB);
        Text text = new Text("text", panelC2);

        IterateParents iterator = new IterateParents();

        PanelA panelAParent = iterator.getFirstPanelAParent(text);
        System.out.println("First panelAParent: " + panelAParent.getName());

        PanelC panelCParent = iterator.getLastPanelCParent(text);
        System.out.println("Last panelCParent: " + panelCParent.getName());
    }

}