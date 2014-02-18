/**
 *  Copyright 2012-2014 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.builtin;

import org.mapstruct.ap.model.BuiltInMethod;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mapstruct.ap.model.common.Parameter;
import org.mapstruct.ap.model.common.Type;
import org.mapstruct.ap.model.common.TypeFactory;
import static org.mapstruct.ap.util.Collections.asSet;

/**
 *
 * @author Sjaak Derksen
 */
public class CalendarToXmlGregorianCalendar extends BuiltInMethod {

    private final Parameter parameter;
    private final Type returnType;

    private final TypeFactory typeFactory;

    public CalendarToXmlGregorianCalendar( TypeFactory typeFactory ) {
        this.typeFactory = typeFactory;
        this.parameter = typeFactory.createParameter( "cal ", Calendar.class );
        this.returnType = typeFactory.getType( XMLGregorianCalendar.class );
    }

    @Override
    public Set<Type> getImportTypes() {
        return asSet( new Type[]{ typeFactory.getType( DatatypeFactory.class ),
            typeFactory.getType( GregorianCalendar.class ),
            typeFactory.getType( DatatypeConfigurationException.class ) } );
    }

    @Override
    public Parameter getParameter() {
        return parameter;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }
}
