<h1>The smarthome brain</h1>
<p>My problem is that the homematic ccu3 offers an API, but some functions that are important to me were missing. So I made it my mission to develop a smarthome brain that provides a rest api for control and for future projects like a website</p>

<p>If you have ideas or want to add support for another bridge, feel free to create a merge request or issue</p>

<h2>Examples</h2>

<h3>homematic</h3>

```console
http://your-server:8080/api/device/state/toggle?deviceID=4644&source=homematicCCUBridgeSource
```

<p>In the case of homematic, the <b>deviceID</b> is the ise_id of the device that you want to control. You can obtain the ID with the following query</p>

```console
http://your-server:8080/api/device/getDevices?source=homematicCCUBridgeSource
```
