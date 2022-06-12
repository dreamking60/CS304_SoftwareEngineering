# progress-report-404notfound

| Group Name:  404NotFound |                |
|:------------------------ |:-------------- |
|                          |                |
| **Team Members**         | **Student ID** |
| 赵晓蕾                      | 11910937       |
| 段轶                       | 11911133       |
| 陈梓涵                      | 11910507       |
| 刘通                       | 11910903       |
| 张庭境                      | 11911919       |

## Issue fix

 a) Reasons for choosing these issues

[modelmapper issue #660](https://github.com/modelmapper/modelmapper/issues/660)

The UUID, short for Universally Unique Identifier, is a 128-bit number which is a standard for software construction.  Ethernet card addresses, nanosecond time, chip ID codes, and many possible numbers were used in calculations. The goal is to allow all elements in a distributed system to have unique identification information, without the need for a central controller to specify identification information. This way, each person can create a UUID that is guaranteed to be unique to all machines in the same space and time. In this case, there is no need to worry about name duplication at database creation. However, the tool previously did not support the UUID type and threw an exception when referring to a UUID. So we need a UUID Converter to do the conversion.

b) Scenarios
[modelmapper issues #572](https://github.com/modelmapper/modelmapper/issues/572)
Add a feature adding typeMapName in the emptyTypeMap method. For a whole read of the whole project code, I find that it only need to add the feature by adding the following method directly, and then we make the test check if it is work.

```java
  /**
   * Creates an empty TypeMap for the {@code sourceType}, {@code destinationType}.
   *
   * @param <S> source type
   * @param <D> destination type
   * @throws IllegalArgumentException is {@code sourceType} or {@code destinationType} are null, or {@code TypeMap<Source Type, DestinationType}
   *  already defined in the TypeMapStore
   */
  public <S, D> TypeMap<S, D> emptyTypeMap(Class<S> sourceType, Class<D> destinationType, String typeMapName) {
    Assert.notNull(sourceType, "sourceType");
    Assert.notNull(destinationType, "destinationType");
    Assert.notNull(typeMapName, "typeMapName");
    Assert.isNull(config.typeMapStore.get(sourceType, destinationType, typeMapName), "TypeMap already defined");
    return config.typeMapStore.createEmptyTypeMap(sourceType, destinationType, typeMapName, config, engine);
  }
```
[modelmapper issue #660](https://github.com/modelmapper/modelmapper/issues/660)

Scenario1: We try to project the type string to UUID, and this is a simple scenario. It should project to the UUID type successfully.

```java
 /**
   * Test mapping the String to UUID type}.
   */
    @Test
    public void test1 () {
        String a = "87180668-ace8-4204-950e-dda74c55f703";
        ModelMapper modelMapper = new ModelMapper();
        UUID uuid = modelMapper.map(a,UUID.class);
        assert uuid.toString().equals(a);
    }
```

Scenario2: This scenario is more complex. UUIDObj and UUIDObjDTO are two objects and it can flatten and project from each other. The fields in these two java classes should match correctly.

```java
/**
   * Test mapping the UUIDObj to UUIDObjDTO}.
   */
    @Test
    public void test2 () {
        ModelMapper modelMapper = new ModelMapper();
        UUIDObj uuidObj = new UUIDObj();
        UUIDObjDTO uuidObjDTO= modelMapper.map(uuidObj,UUIDObjDTO.class);
        assert uuidObjDTO.getUuid().toString().equals(uuidObj.getUuid());
    }
```
c)

- [modelmapper issues #572](https://github.com/modelmapper/modelmapper/issues/572):
   [pull request](https://github.com/modelmapper/modelmapper/pull/664)

-  [modelmapper issues #660](https://github.com/modelmapper/modelmapper/issues/660):

   [pull request](https://github.com/modelmapper/modelmapper/pull/663)





d)Three static analysis tools

[modelmapper issues #572](https://github.com/modelmapper/modelmapper/issues/572):

##### Checkstyle

The problem here is because I follow the rule of developer.

![](./pic/checkstyle_Issue572.png)

##### PMD

The problem of PMD test for me is because I follow the rules with the developer.

![](./pic/PMD_Issue572.png)

##### SpotBugs

There is an error, but this error is not my work, it is developer's variable.

![](./pic/SpotBug_Issue572.png)

 [modelmapper issues #660](https://github.com/modelmapper/modelmapper/issues/660):
##### Checkstyle
![](./pic/checkStyle#660.png)
##### PMD
![](./pic/PMD#660.png)
##### SpotBugs
![](./pic/Spotbugs#660.png)



## Plan

| Week | Work |
| ---- | ---- |
| 12   |      |
| 13   |      |
| 14   |      |

## 
