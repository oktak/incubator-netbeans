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
package org.netbeans.modules.html.editor.indexing;

import org.netbeans.modules.csl.api.OffsetRange;

public class Entry {

    private String name;
    private OffsetRange astRange;
    private OffsetRange documentRange;

    protected Entry(String name, OffsetRange astRange, OffsetRange documentRange) {
        this.name = name;
        this.astRange = astRange;
        this.documentRange = documentRange;
    }

    public boolean isValidInSourceDocument() {
        return documentRange != null;
    }

    public String getName() {
        return name;
    }

    public OffsetRange getDocumentRange() {
        return documentRange;
    }

    public OffsetRange getRange() {
        return astRange;
    }

    @Override
    public String toString() {
        return "Entry[" + (!isValidInSourceDocument() ? "INVALID! " : "") + getName() + "; " + getRange().getStart() + " - " + getRange().getEnd() + "]"; //NOI18N
    }
}
