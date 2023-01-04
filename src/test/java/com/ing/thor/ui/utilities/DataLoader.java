package com.ing.thor.ui.utilities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataLoader {

    @Value("${data.list.path}")
    protected String dataListPath;

    public Map<String, Data> dataList;

    public Map<String, Data> getDataList() throws IOException, URISyntaxException {

        URI path = getClass().getClassLoader().getResource(dataListPath).toURI();
        DataListWrapper mapper = new ObjectMapper().readValue(new File(path), DataListWrapper.class);
       dataList = mapper.getDataList().stream().collect(Collectors.toMap(Data::getId, c->c));
       return dataList;
    }

    public Data getCustomerData(String customerKey) throws IOException, URISyntaxException {

        return this.getDataList().get(customerKey);
    }
}
