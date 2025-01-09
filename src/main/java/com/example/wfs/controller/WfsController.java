package com.example.wfs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wfs")
public class WfsController {


    @GetMapping("/GetCapabilities")
    public String getCapabilities() {
        return """
            <WFS_Capabilities>
                <FeatureTypeList>
                    <FeatureType>
                        <Name>features</Name>
                        <Title>Sample Features</Title>
                    </FeatureType>
                </FeatureTypeList>
            </WFS_Capabilities>
        """;
    }

    @GetMapping("/DescribeFeatureType")
    public String describeFeatureType() {
        return """
            <xsd:schema>
                <xsd:element name="Feature" type="FeatureType"/>
                <xsd:complexType name="FeatureType">
                    <xsd:sequence>
                        <xsd:element name="id" type="xsd:long"/>
                        <xsd:element name="name" type="xsd:string"/>
                        <xsd:element name="geometry" type="xsd:string"/>
                    </xsd:sequence>
                </xsd:complexType>
            </xsd:schema>
        """;
    }
}
