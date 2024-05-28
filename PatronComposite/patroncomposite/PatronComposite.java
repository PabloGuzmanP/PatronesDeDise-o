    package patroncomposite;

    import java.util.Random;

    import composicion.ordenes.OrdenVenta;
    import composicion.productos.ConfiguracionCompuestaProducto;
    import composicion.productos.ConfiguracionSimpleProducto;

    public class PatronComposite {
        private final Random random = new Random();

        private ConfiguracionSimpleProducto ram4gb;
        private ConfiguracionSimpleProducto ram8gb;
        private ConfiguracionSimpleProducto disk500gb;
        private ConfiguracionSimpleProducto disk1tb;
        private ConfiguracionSimpleProducto cpuAMD;
        private ConfiguracionSimpleProducto cpuIntel;
        private ConfiguracionSimpleProducto smallCabinete;
        private ConfiguracionSimpleProducto bigCabinete;
        private ConfiguracionSimpleProducto monitor20inch;
        private ConfiguracionSimpleProducto monitor30inch;
        private ConfiguracionSimpleProducto simpleMouse;
        private ConfiguracionSimpleProducto gammerMouse;
        private ConfiguracionSimpleProducto headset;

        private ConfiguracionCompuestaProducto gammerPC;
        private ConfiguracionCompuestaProducto homePC;
        private ConfiguracionCompuestaProducto pc2x1;
        
        private void CreardProductos() {
            //Configuraciòn de productos simples
            ram4gb = new ConfiguracionSimpleProducto("RAM 4GB", 750, 15, 2, "KingStone");
            ram8gb = new ConfiguracionSimpleProducto("RAM 8GB", 1000, 15, 2, "KingStone");
            disk500gb = new ConfiguracionSimpleProducto("HDD 500GB", 1500, 15, 2, "ACME");
            disk1tb = new ConfiguracionSimpleProducto("HDD 1TB", 2000, 15, 2, "ACME");
            cpuAMD = new ConfiguracionSimpleProducto("AMD phenon", 4000, 15, 2, "AMD");
            cpuIntel = new ConfiguracionSimpleProducto("Intel i7", 4500, 15, 2, "Intel");
            smallCabinete = new ConfiguracionSimpleProducto("Small cabinet", 2000, 15, 2, "ExCom");
            bigCabinete = new ConfiguracionSimpleProducto("Big Cabinet", 2200, 15, 2, "ExCom");
            monitor20inch = new ConfiguracionSimpleProducto("Display 20'", 1500, 15, 2, "HP");
            monitor30inch = new ConfiguracionSimpleProducto("Display 30'", 2000, 15, 2, "HP");
            simpleMouse = new ConfiguracionSimpleProducto("Simple mouse", 150, 15, 2, "Genius");
            gammerMouse = new ConfiguracionSimpleProducto("Gammer mouse", 750, 15, 2, "Alien");
            headset = new ConfiguracionSimpleProducto("HeadSet", -7000, 15, 2, "Logitech");

            //Producto Compuesto con: Gammer pc de 8gb ram,HDD 1tb, Intel i7 processor
            //large cabinet,display 30' y one gammer mouse.
            gammerPC = new ConfiguracionCompuestaProducto("Gammer PC");
            gammerPC.AgregarProducto(ram8gb);
            gammerPC.AgregarProducto(disk1tb);
            gammerPC.AgregarProducto(cpuIntel);
            gammerPC.AgregarProducto(bigCabinete);
            gammerPC.AgregarProducto(monitor30inch);
            gammerPC.AgregarProducto(gammerMouse);

            //Paquete: Home PC con RAM 4gb, HDD 500gb, AMD Phenon processor
            //small Cabinet, dsplay 20' y simple mouse.
            homePC = new ConfiguracionCompuestaProducto("Home PC");
            homePC.AgregarProducto(ram4gb);//
            homePC.AgregarProducto(disk500gb);
            homePC.AgregarProducto(cpuAMD);
            homePC.AgregarProducto(smallCabinete);
            homePC.AgregarProducto(monitor20inch);
            homePC.AgregarProducto(simpleMouse);
            homePC.AgregarProducto(headset);

            //Combo confirmado por 2 paquetes, Gammer PC + Home PC
            pc2x1 = new ConfiguracionCompuestaProducto("Pack PC Gammer + Home PC");
            pc2x1.AgregarProducto(gammerPC);
            pc2x1.AgregarProducto(homePC);
        }
        
        private void OrdenVentaParaConfiguracionSimpleProducto() {

            OrdenVenta OrdenConfiguracionSimple = new OrdenVenta(random.nextInt(), "Hector Lavoe");
            OrdenConfiguracionSimple.AgregarProducto(ram4gb);
            OrdenConfiguracionSimple.AgregarProducto(disk1tb);
            OrdenConfiguracionSimple.AgregarProducto(simpleMouse);
            OrdenConfiguracionSimple.ImprimirOrdenVenta();
        }
        
        private void OrdenVentaGammerPC() {
            OrdenVenta gammerOrdenVenta = new OrdenVenta(1, "Ismael Rivera");
            gammerOrdenVenta.AgregarProducto(gammerPC);
            gammerOrdenVenta.ImprimirOrdenVenta();
        }
        
        private void OrdenVentaHomePC() {
            OrdenVenta homeOrdenVenta = new OrdenVenta(2, "Celia Cruz");
            homeOrdenVenta.AgregarProducto(homePC);
            homeOrdenVenta.ImprimirOrdenVenta();
        }
        private void OrdenVentaCombo() {
            OrdenVenta comboOrdenVenta = new OrdenVenta(3, "Paquete 2x1 en PC");
            comboOrdenVenta.AgregarProducto(pc2x1);
            comboOrdenVenta.ImprimirOrdenVenta();
        }
        
        private void OrdenVentaMega() {
            OrdenVenta OrdenVentaPersonalizada = new OrdenVenta(4, "Tito Nieves");
            OrdenVentaPersonalizada.AgregarProducto(homePC);
            OrdenVentaPersonalizada.AgregarProducto(ram8gb);
            OrdenVentaPersonalizada.AgregarProducto(ram4gb);
            OrdenVentaPersonalizada.AgregarProducto(monitor30inch);
            OrdenVentaPersonalizada.AgregarProducto(gammerMouse);
            OrdenVentaPersonalizada.ImprimirOrdenVenta();
        }
        
        public static void main(String[] args) {
            PatronComposite main = new PatronComposite();
            main.CreardProductos();

            //main.OrdenVentaParaConfiguracionSimpleProducto();
            main.OrdenVentaHomePC();
            //main.OrdenVentaGammerPC();
            //main.OrdenVentaCombo();
            //main.OrdenVentaMega();
        }
    }
