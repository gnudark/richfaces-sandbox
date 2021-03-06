package org.richfaces.sandbox.composite;
/**
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 **/

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://community.jboss.org/people/bleathem">Brian Leathem</a>
 */
@FacesComponent("org.richfaces.sandbox.composite.UITabs")
public class UITabs extends UINamingContainer {
    enum PropertyKeys {selected}

    public int getSelected() {
        return (Integer) getStateHelper().eval(PropertyKeys.selected, 0);
    }

    public void setSelected(int selected) {
        getStateHelper().put(PropertyKeys.selected, selected);
    }

    public List<UIComponent> getTabChildren() {
        List<UIComponent> children = this.getFacet("javax.faces.component.COMPOSITE_FACET_NAME").getChildren();
        List<UIComponent> tabChildren = new ArrayList<UIComponent>();
        for (UIComponent child : children) {
            if (child instanceof UITab) {
                tabChildren.add(child);
            }
        }
        return tabChildren;
    }
}