import javax.swing.JOptionPane;

public class Retangulo {
    private Double lado1;
    private Double lado2;
    private Double area;
    private Double perimetro;

    public Retangulo() {
    }

    public Retangulo(Double lado1, Double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Double getLado1() {
        return lado1;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
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
        if (lado1 != null && lado2 != null) {
            this.area = lado1 * lado2;
        }
    }

    public void calcularPerimetro() {
        if (lado1 != null && lado2 != null) {
            this.perimetro = 2 * (lado1 + lado2);
        }
    }

    public static void main(String[] args) {
        // Criando o primeiro objeto Retangulo
        Retangulo retangulo1 = new Retangulo(10.0, 5.0);
        retangulo1.calcularArea();
        JOptionPane.showMessageDialog(null, "Área do retângulo 1: " + retangulo1.getArea());
        retangulo1.calcularPerimetro();
        JOptionPane.showMessageDialog(null, "Perímetro do retângulo 1: " + retangulo1.getPerimetro());

        // Atualizando lado2 e recalculando área e perímetro
        retangulo1.setLado2(7.0);
        JOptionPane.showMessageDialog(null, "Novo valor para lado2: 7.0");
        retangulo1.calcularArea();
        JOptionPane.showMessageDialog(null, "Nova área do retângulo 1: " + retangulo1.getArea());
        retangulo1.calcularPerimetro();
        JOptionPane.showMessageDialog(null, "Novo perímetro do retângulo 1: " + retangulo1.getPerimetro());

        // Criando mais 5 instâncias de Retangulo
        for (int i = 2; i <= 6; i++) {
            Retangulo retangulo = new Retangulo(10.0, 5.0);
            retangulo.calcularArea();
            JOptionPane.showMessageDialog(null, "Área do retângulo " + i + ": " + retangulo.getArea());
            retangulo.calcularPerimetro();
            JOptionPane.showMessageDialog(null, "Perímetro do retângulo " + i + ": " + retangulo.getPerimetro());

            // Atualizando lado2 e recalculando área e perímetro
            retangulo.setLado2(7.0);
            JOptionPane.showMessageDialog(null, "Novo valor para lado2: 7.0");
            retangulo.calcularArea();
            JOptionPane.showMessageDialog(null, "Nova área do retângulo " + i + ": " + retangulo.getArea());
            retangulo.calcularPerimetro();
            JOptionPane.showMessageDialog(null, "Novo perímetro do retângulo " + i + ": " + retangulo.getPerimetro());
        }
    }
}
