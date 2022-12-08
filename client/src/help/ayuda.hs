<?xml version="1.0" encoding="ISO-8859-1"?>
<helpset>
    <title>Ayuda general</title>
    <maps>
        <homeID>index</homeID>		
        <mapref location="ayuda.jhm"/>	
    </maps>


    <view>						
        <name>Tabla de contenidos</name>
        <label>Tabla de contenidos</label>	
        <type>javax.help.TOCView</type>
        <data>ayudaTOC.xml</data>		
    </view>

    <view>						
        <name>Favoritos</name>
        <label>Favoritos</label>	
        <type>javax.help.FavoritesView</type>		
    </view>

    <view>						
        <name>Busqueda</name>
        <label>Busqueda</label>	
        <type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data>
        		
    </view>

    <presentation default="true" displayviews="true" displayviewimages="true">
        <name>MainWin</name>
        <size width="600" height="500"/>		
        <location x="200" y="100"/>			
        <title></title> 
        <toolbar>	
                        
            <helpaction>javax.help.BackAction</helpaction>
            <helpaction>javax.help.ForwardAction</helpaction>
            <helpaction>javax.help.SeparatorAction</helpaction>
            <helpaction>javax.help.HomeAction</helpaction>
            <helpaction>javax.help.ReloadAction</helpaction>
            <helpaction>javax.help.FavoritesAction</helpaction>

        </toolbar>
    </presentation>                



</helpset>
