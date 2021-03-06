/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.visual.action;

import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.action.TwoStateHoverProvider;

/**
 * @author David Kaspar
 */
public final class TwoStatedMouseHoverAction extends WidgetAction.Adapter {

    private long eventID = Integer.MIN_VALUE;
    private TwoStateHoverProvider provider;
    private Widget lastWidget;

    public TwoStatedMouseHoverAction (TwoStateHoverProvider provider) {
        this.provider = provider;
    }

    public State mouseMoved (Widget widget, WidgetMouseEvent event) {
        long id = event.getEventID ();
        if (id != eventID) {
            eventID = id;
            widgetHovered (widget);
        }
        return State.REJECTED;
    }

    public State mouseExited (Widget widget, WidgetMouseEvent event) {
        long id = event.getEventID ();
        if (id != eventID) {
            eventID = id;
            widgetHovered (null);
        }
        return State.REJECTED;
    }

    public void widgetHovered (Widget widget) {
        if (widget instanceof Scene)
            widget = null;

        if (lastWidget == widget)
            return;

        if (lastWidget != null)
            provider.unsetHovering (lastWidget);

        lastWidget = widget;

        if (widget != null)
            provider.setHovering (widget);
    }

}
