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

package clienteditor;

import org.jdesktop.beansbinding.Converter;

/**
 * <code>Integer</code> to <code>String</code> converter
 * that returns zero when the argument cannot be parsed.
 * 
 * @author Jiri Vagner, Jan Stola
 */
public class AgeConverter extends Converter<Integer, String> {

    public String convertForward(Integer arg) {
        return String.valueOf(arg);
    }

    public Integer convertReverse(String arg) {
        int value;
        try {
            value = (arg == null) ? 0 : Integer.parseInt(arg);
        } catch (NumberFormatException ex) {
            value = 0;
        }
        return value;
    }

}
