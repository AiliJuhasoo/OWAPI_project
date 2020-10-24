# ITI0203-2020 Part 1 Backend

## team_32
| Members               | Uni ID     |
| --------------------- | ---------- |
| Darya Harachka        | 184053IVSB |
| Aili Juhasoo-Lawrence | 184917IVSB |

## Open Weather config
To configure your own API token for External API access:
- add 'custom_config.yaml' file under /src/main/resources with the following contents:

```
app:
   open-weather:
     key: <your_key>
     url: https://api.openweathermap.org/data/2.5/onecall
```
     
- add the following to your Environment->VM options configuration:

`-Dspring.conf.location=/src/main/resources/custom_config.yaml`

## Helpful Commands
`gradle wrapper` - Generate wrapper. Run it once for the first time.  
`./gradlew bootRun` - Compile and start the application.  
`./gradlew build` - Compile the application. Result will be a `.jar` file in `./build/libs/` dir.  
`java -jar ./build/libs/ics0024-0.0.1-SNAPSHOT.jar` - Run the compiled jar file.

## Testing Commands
`./gradlew test` - Run tests.

You can find Api documentation at [swagger](http://localhost:8080/swagger-ui/)

