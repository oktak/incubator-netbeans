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

package org.netbeans.modules.spellchecker.bindings.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.ChangeListener;
import javax.swing.text.Document;
import javax.swing.text.Position;
import junit.framework.TestCase;
import org.openide.filesystems.FileObject;

/**
 *
 * @author lahvac
 */
public class JavaSemanticTokenListTest extends TestCase {
    
    public JavaSemanticTokenListTest(String testName) {
        super(testName);
    }            

    public void testSeparateWords() throws Exception {
        assertEquals(Arrays.asList("test"), JavaSemanticTokenList.separateWords("test", new LinkedList<int[]>()));
        assertEquals(Arrays.asList("test", "Test"), JavaSemanticTokenList.separateWords("testTest", new LinkedList<int[]>()));
        assertEquals(Arrays.asList("HTMLtest"), JavaSemanticTokenList.separateWords("HTMLtest", new LinkedList<int[]>()));
    }
}
