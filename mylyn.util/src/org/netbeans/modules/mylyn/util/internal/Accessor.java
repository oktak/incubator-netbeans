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
package org.netbeans.modules.mylyn.util.internal;

import java.util.Collection;
import java.util.Set;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.netbeans.modules.mylyn.util.MylynSupport;
import org.netbeans.modules.mylyn.util.NbTask;
import org.netbeans.modules.mylyn.util.NbTaskDataModel;

/**
 *
 * @author Ondrej Vrabec
 */
public abstract class Accessor {
    private static Accessor instance;

    public static boolean isInitialized () {
        return instance != null;
    }
    
    public static Accessor getInstance () {
        MylynSupport.getInstance();
        return instance;
    }

    public static void setInstance (Accessor instance) {
        Accessor.instance = instance;
    }

    public abstract void finishMylyn () throws CoreException;

    public abstract Collection<NbTask> toNbTasks (Set<ITask> tasks);

    public abstract NbTask toNbTask (ITask task);

    public abstract Set<ITask> toMylynTasks (Set<NbTask> tasks);

    public abstract ITask getITask (NbTaskDataModel model);

    public abstract TaskRepository getTaskRepositoryFor (ITask task);

    public abstract ITask getDelegate (NbTask task);

    public abstract NbTask getOrCreateTask (TaskRepository taskRepository, String taskId, boolean addToTasklist) throws CoreException;

    public abstract void taskModified (NbTask nbTask);
    
}
