import org.junit.jupiter.api.*;

import org.junit.jupiter.api.condition.*;
import votos.models.Urna;
import votos.models.Partido;

import java.util.Properties;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UrnaTest {

    @BeforeEach
    void initMetodoTest(){
        System.out.println("Iniciando el metodo");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Finalizando");
    }


    @BeforeAll
    void beforeAll(){
        System.out.println("Inicializando el test");
    }

    @AfterAll
    void afterAll(){
        System.out.println("Finalizando el test");
    }

    @Test
    @DisplayName("Votos de urna")
    void testVotosCandidato() {
        Urna urna = new Urna("Javier", 25);
        Assertions.assertNotNull(urna.getVotos());
        Assertions.assertEquals(25, urna.getVotos());
        Assertions.assertFalse(urna.getVotos() < 0);
        Assertions.assertTrue(urna.getVotos() > 0);
    }

    @Test
    @DisplayName("Probando el nombre del candidato")
    void testNombreCandidato() {
        Urna urna = new Urna("Javier", 24);
        //cuenta.setPersona("Javier");
        String esperado = "Javier";
        String real = urna.getCandidato();
        Assertions.assertEquals(esperado, real);
        Assertions.assertNotNull(real, "La cuenta no puede ser nula");
        Assertions.assertEquals(esperado, real, "El nombre de la cuenta no es el que se esperaba" + esperado);
        Assertions.assertTrue(real.equals("Javier"), "Nombre cuenta esperado debe ser igual al real");
    }

    @Test
    @DisplayName("Relacion de Candidatos y partido")
    void testRelacionPartidoCandidatos() {
        Urna urna1 = new Urna("Javier", 50);
        Urna urna2 = new Urna("Efrain Razo", 23);
        Partido partido = new Partido();
        partido.addCandidato(urna1);
        partido.addCandidato(urna2);
        partido.setNombre("Partido Rosa");
        partido.votar(urna1, 1);
        Assertions.assertAll(() -> {
                    Assertions.assertEquals(23, urna2.getVotos());
                },
                () -> {
                    Assertions.assertEquals(51, urna1.getVotos());
                },
                () -> {
                    Assertions.assertEquals(2, partido.getUrnas().size());
                },
                () -> {
                    Assertions.assertEquals("Partido Rosa", urna1.getPartido().getNombre());
                },
                () -> {
                    Assertions.assertEquals("Javier", partido.getUrnas().stream()
                            .filter(c -> c.getCandidato().equals("Javier"))
                            .findFirst().get().getCandidato());
                },
                () -> {
                    Assertions.assertTrue(partido.getUrnas().stream()
                            .anyMatch(c -> c.getCandidato().equals("Javier")));
                }
        );


    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows(){

    }

    @Disabled
    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac(){

    }

    @Test
    @DisabledOnOs({OS.LINUX, OS.MAC})
    void testNoLinuxMac(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void soloJDK8(){

    }

    @Test
    void imprimirSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "21.0.6")
    void testJavaVersion(){

    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testSolo64(){

    }



}
