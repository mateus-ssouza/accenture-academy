import javax.swing.JOptionPane;

public class Circulo {
    private Double raio;
    private Double area;
    private Double perimetro;

    public Circulo() {
    }

    public Circulo(Double raio) {
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Double perimetro) {
        this.perimetro = perimetro;
    }

    public void calcularArea() {
        if (raio != null) {
            this.area = Math.PI * Math.pow(raio, 2);
        }
    }

    public void calcularPerimetro() {
        if (raio != null) {
            this.perimetro = 2 * Math.PI * raio;
        }
    }

    public static void main(String[] args) {
        // Criação do primeiro objeto Circulo
        Circulo circulo1 = new Circulo(10.0);
        circulo1.calcularArea();
        JOptionPane.showMessageDialog(null, "Área do círculo 1: " + circulo1.getArea());
        circulo1.calcularPerimetro();
        JOptionPane.showMessageDialog(null, "Perímetro do círculo 1: " + circulo1.getPerimetro());

        // Atualizando raio e recalculando área e perímetro
        circulo1.setRaio(4.0);
        circulo1.calcularArea();
        JOptionPane.showMessageDialog(null, "Nova área do círculo 1: " + circulo1.getArea());
        circulo1.calcularPerimetro();
        JOptionPane.showMessageDialog(null, "Novo perímetro do círculo 1: " + circulo1.getPerimetro());

        // Criando mais 5 instâncias de Circulo
        for (int i = 2; i <= 6; i++) {
            Circulo circulo = new Circulo(10.0);
            circulo.calcularArea();
            JOptionPane.showMessageDialog(null, "Área do círculo " + i + ": " + circulo.getArea());
            circulo.calcularPerimetro();
            JOptionPane.showMessageDialog(null, "Perímetro do círculo " + i + ": " + circulo.getPerimetro());

            // Atualizando raio e recalculando área e perímetro
            circulo.setRaio(4.0);
            circulo.calcularArea();
            JOptionPane.showMessageDialog(null, "Nova área do círculo " + i + ": " + circulo.getArea());
            circulo.calcularPerimetro();
            JOptionPane.showMessageDialog(null, "Novo perímetro do círculo " + i + ": " + circulo.getPerimetro());
        }
    }
}
