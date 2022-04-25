package fr.ign.lastig.test;

import static java.util.Collections.singleton;

import org.apache.sis.internal.geoapi.evolution.UnsupportedCodeList;
import org.apache.sis.internal.system.DefaultFactories;
import org.apache.sis.metadata.iso.citation.DefaultCitation;
import org.apache.sis.metadata.iso.identification.DefaultCoupledResource;
import org.apache.sis.metadata.iso.identification.DefaultOperationMetadata;
import org.apache.sis.metadata.iso.identification.DefaultServiceIdentification;
import org.apache.sis.xml.NilReason;
import org.apache.sis.xml.XML;
import org.opengis.metadata.citation.Citation;
import org.opengis.metadata.citation.OnlineResource;
import org.opengis.util.NameFactory;
import org.opengis.util.ScopedName;

public class TestService {

	/*public static ServiceParameter create() {
    final MemberName paramName = Names.createMemberName(null, null, "Version", String.class);
    final ServiceParameter param = new ServiceParameter();
    param.memberName    = paramName;
    param.optionality   = true;
    param.repeatability = false;
    return param;
}*/

 /**
 * Creates the resource to use for testing purpose.
 */
static DefaultCoupledResource create(final NameFactory factory) {
    final DefaultOperationMetadata operation = new DefaultOperationMetadata();
    operation.setOperationName("Get Map");
    operation.setDistributedComputingPlatforms(singleton(UnsupportedCodeList.valueOf("WEB_SERVICES")));
    //operation.setParameters(singleton((ParameterDescriptor<?>) create()));
    operation.setConnectPoints(singleton(NilReason.MISSING.createNilObject(OnlineResource.class)));

    final DefaultCoupledResource resource = new DefaultCoupledResource();
    resource.setScopedName((ScopedName) factory.createGenericName(null, "mySpace", "ABC-123"));
    resource.setOperation(operation);
    return resource;
}

public static void main(String[] args) throws Exception {
	
	// createMetadata();
	
	final NameFactory factory = DefaultFactories.forBuildin(NameFactory.class);
    final DefaultCoupledResource resource = create(factory);
    resource.setResourceReferences(singleton(new DefaultCitation("WMS specification")));
    final DefaultServiceIdentification id = new DefaultServiceIdentification(
            factory.createGenericName(null, "Web Map Server"),      // serviceType
            NilReason.MISSING.createNilObject(Citation.class),      // citation
            "A dummy service for testing purpose.");                // abstract
    id.setServiceTypeVersions(singleton("1.0"));
    id.setCoupledResources(singleton(resource));
    id.setCouplingType(UnsupportedCodeList.valueOf("LOOSE"));
    id.setContainsOperations(singleton(resource.getOperation()));
    
    System.out.println(XML.marshal(id));
}

}
