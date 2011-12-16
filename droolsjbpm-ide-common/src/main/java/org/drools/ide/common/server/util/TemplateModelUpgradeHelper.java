/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.ide.common.server.util;

import org.drools.ide.common.client.modeldriven.brl.templates.InterpolationVariable;
import org.drools.ide.common.client.modeldriven.brl.templates.TemplateModel;

/**
 * Utility class to support upgrades of the TemplateModel model
 */
public class TemplateModelUpgradeHelper
    implements
    IUpgradeHelper<TemplateModel, TemplateModel> {

    public TemplateModel upgrade(TemplateModel model) {
        updateInterpolationVariableFieldTypes( model );
        return model;
    }

    private void updateInterpolationVariableFieldTypes(TemplateModel model) {
        //Fields' data-types may be qualified with Fact type. This can be removed
        for ( InterpolationVariable variable : model.getInterpolationVariablesList() ) {
            variable.setFactField( variable.getFactField() );
        }
    }

}
