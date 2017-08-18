package softuni.softuni.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import softuni.softuni.serializers.Serializer;
import softuni.softuni.services.DSLRService;

@Controller
public class DSLRController {

    private final Serializer jsonSerializer;
    private final Serializer xmlSerializer;
    private final DSLRService dSLRService;

    @Autowired
    public DSLRController(@Qualifier("json") Serializer jsonSerializer, @Qualifier("xml") Serializer xmlSerializer, DSLRService dSLRService) {
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
        this.dSLRService = dSLRService;
    }
}