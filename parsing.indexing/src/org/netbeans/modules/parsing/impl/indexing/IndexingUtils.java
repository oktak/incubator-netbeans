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
package org.netbeans.modules.parsing.impl.indexing;

import java.util.Set;
import org.netbeans.api.annotations.common.NonNull;
import org.openide.util.Parameters;

/**
 *
 * @author sdedic
 */
public final class IndexingUtils {
    public static void runAsScanWork(@NonNull Runnable work) {
        Parameters.notNull("work", work);   //NOI18N
        RepositoryUpdater.getDefault().runAsWork(work);
    }
    
    /**
     * Sets the {@link IndexingStatus}
     * @param st an {@link IndexingStatus}
     */
    public static void setIndexingStatus (final IndexingStatus st) {
        assert st != null;
        assert status == null;
        status = st;
    }

    public static Set<? extends RepositoryUpdater.IndexingState> getIndexingState() {
        if (status == null) {
            return RepositoryUpdater.getDefault().getIndexingState();
        } else {
            return status.getIndexingState();
        }
    }

    /**
     * Asks the {@link IndexingStatus} about state of indexing
     * @return true when indexing is active
     */
    public static boolean isScanInProgress () {
        return !getIndexingState().isEmpty();        
    }
    //where
    private static volatile IndexingStatus status;

    /**
     * Provides state of indexing
     */
    public static interface IndexingStatus {
        Set<? extends RepositoryUpdater.IndexingState> getIndexingState ();
    }
    
    private IndexingUtils() {}
}
