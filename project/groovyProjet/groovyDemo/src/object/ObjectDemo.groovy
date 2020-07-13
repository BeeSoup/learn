package object

def obj = new GroovyObj();
obj.say();

GroovyObj.metaClass.myName = 'zhang'

GroovyObj.metaClass.setMyNameIs = {ob -> {
    println "hhh"
}}

GroovyObj.metaClass.static.myStaticMethod = {
    String name ->
        println name

}

def obj2 = new GroovyObj()
obj2.setMyNameIs(1)