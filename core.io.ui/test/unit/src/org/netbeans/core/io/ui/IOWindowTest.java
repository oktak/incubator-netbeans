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
package org.netbeans.core.io.ui;

import javax.swing.JPanel;
import org.junit.Assert;
import org.junit.Test;
import org.openide.util.Utilities;

/**
 *
 * @author jhavlin
 */
public class IOWindowTest {

    public IOWindowTest() {
    }

    /**
     * Test for bug 254566 - Output window is hogging space with minimum
     * vertical space requirement.
     */
    @Test
    public void testMinimumHeight() {
        IOWindow.IOWindowImpl ioWin = IOWindow.IOWindowImpl.findDefault();
        if (Utilities.isMac()) {
            ioWin.addTab(new JPanel(), null);
            ioWin.addTab(new JPanel(), null);
            int minHeight = ioWin.getMinimumSize().height;
            ioWin.addTab(new JPanel(), null);
            Assert.assertEquals("Adding tab should not affect minimum height of"
                    + " the window.", minHeight, ioWin.getMinimumSize().height);
        }
    }
}
