package com.ushara.dengigo.config.application;


public class TilesDefinitionsConfig implements DefinitionsFactory{
    private static final Map<String, Definition> tilesDefinitions = new HashMap<String,Definition>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/layout/layout.jsp");

    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<String,Attribute>();
        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/WEB-INF/views/layout/header.jsp"));
//        attributes.put("menu", new Attribute("/WEB-INF/views/layout/menu.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/views/layout/footer.jsp"));
        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    public static void addDefinitions(){
        addDefaultLayoutDef("firstPage", "First Page", "/WEB-INF/views/first.jsp");
        addDefaultLayoutDef("secondPage", "Second Page", "/WEB-INF/views/second.jsp");

    }
}
