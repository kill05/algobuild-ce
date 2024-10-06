package com.github.kill05.algobuildce.package_a.j.a;

import com.github.kill05.algobuildce.package_a.c.a.ABProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import javax.swing.JPanel;

public final class ABConsole extends JPanel {

    private static Color[] COLORS = new Color[]{
            new Color(191, 255, 255),
            new Color(255, 191, 255),
            new Color(255, 255, 191),
            new Color(255, 191, 191),
            new Color(191, 255, 191),
            new Color(191, 191, 255)
    };

    private final ABProgram program;
    private final Vector<ConsoleMessage> lines;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public ABConsole(ABProgram program) {
        this.lines = new Vector<>(100);
        this.program = program;
        this.e = 0;
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
        int totalHeight = 0;
        int var4 = 0;

        for (ConsoleMessage value : this.lines) {
            String var7 = value.getMessage();
            Rectangle2D stringBounds = fontMetrics.getStringBounds(var7, g);

            int var9;
            int var10;
            if (!value.isTrace()) {
                var9 = 0;
                if (this.program.getExecutionOptions().isTraceEnabled()) {
                    var10 = (int) (0.25D * (double) fontMetrics.getHeight());
                    var9 = value.getIndent() * fontMetrics.getHeight();
                    g.setColor(COLORS[value.getIndent() % COLORS.length]);
                    g.fillRect(var9 - var10, totalHeight, var10, fontMetrics.getHeight());
                }

                g.setColor(Color.BLACK);
                g.drawString(var7, var4 + var9, (int) ((double) totalHeight - stringBounds.getY()));
                var4 += (int) stringBounds.getWidth();
                if (value.isEndLine()) {
                    var4 = 0;
                }

                if (value.isEndLine() || this.program.getExecutionOptions().isTraceEnabled()) {
                    totalHeight += (int) stringBounds.getHeight();
                }
            } else if (this.program.getExecutionOptions().isTraceEnabled()) {
                var9 = (int) (0.25D * (double) fontMetrics.getHeight());
                var10 = value.getIndent() * fontMetrics.getHeight();
                g.setColor(COLORS[value.getIndent() % COLORS.length]);
                g.fillRect(var10 - var9, totalHeight, var9, fontMetrics.getHeight());
                g.fillRect(var10, totalHeight, (int) stringBounds.getWidth(), (int) stringBounds.getHeight());
                if (value.isError()) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLUE);
                }

                g.drawString(var7, var10, (int) ((double) totalHeight - stringBounds.getY()));
                totalHeight += (int) stringBounds.getHeight();
            }
        }

    }

    void a() {
        Graphics var1 = this.getGraphics();
        FontMetrics var2 = this.getFontMetrics(this.getFont());
        int var3 = 0;
        int var4 = 0;
        int messageHeight = 10;
        this.d = this.c = this.g = this.f = 0;

        for (ConsoleMessage message : this.lines) {
            String messageStr = message.getMessage();
            Rectangle2D messageBounds = var2.getStringBounds(messageStr, var1);
            messageHeight = (int) messageBounds.getHeight();
            int var9;
            if (!message.isTrace()) {
                var9 = message.getIndent() * var2.getHeight();
                if ((var4 += (int) messageBounds.getWidth()) > this.d) {
                    this.d = var4;
                }

                if (var4 + var9 > this.g) {
                    this.g = var4 + var9;
                }

                this.c = (int) messageBounds.getHeight() + var3;
                if (message.isEndLine()) {
                    var4 = 0;
                }

                if (message.isEndLine()) {
                    var3 += (int) messageBounds.getHeight();
                }
            } else if ((var9 = message.getIndent() * var2.getHeight()) + (int) messageBounds.getWidth() > this.g) {
                this.g = var9 + (int) messageBounds.getWidth();
            }
        }

        this.f = this.lines.size() * messageHeight;
        this.revalidate();
        this.repaint();
    }

    public void a(String var1, boolean var2, boolean var3, boolean var4) {
        if (var3) {
            var1 = var1.replaceAll("\\\\n", "");
            var2 = false;
        }

        String[] var12 = var1.split("\\\\n");
        FontMetrics var5 = this.getFontMetrics(this.getFont());
        int var6 = this.e * var5.getHeight();
        Graphics var7 = this.getGraphics();
        Rectangle2D var8 = null;
        int var9 = 0;

        for (int i = 0; i < var12.length; ++i) {
            boolean var11 = var2 || i < var12.length - 1;
            if (!var12[i].isEmpty() || var11) {
                ++var9;
                ConsoleMessage var13 = new ConsoleMessage(var12[i], this.e, var11, var3, var4);
                this.lines.add(var13);
                var8 = var5.getStringBounds(var12[i], var7);
                if (!var3) {
                    if (var11) {
                        this.h = 0;
                        this.i += (int) var8.getHeight();
                    } else {
                        this.h += (int) var8.getWidth();
                    }

                    if ((double) this.h + var8.getWidth() > (double) this.d) {
                        this.d = this.h + (int) var8.getWidth();
                    }

                    this.c = this.i + (int) var8.getHeight();
                }

                if ((double) (var6 + this.h) + var8.getWidth() > (double) this.g) {
                    this.g = var6 + this.h + (int) var8.getWidth();
                }
            }
        }

        if (var9 > 0) {
            this.f = this.lines.size() * (int) var8.getHeight();
            this.revalidate();
            if (!this.program.getExecutionOptions().isTraceEnabled()) {
                this.scrollRectToVisible(new Rectangle(this.h, this.i, (int) var8.getWidth(), (int) var8.getHeight()));
            } else {
                this.scrollRectToVisible(new Rectangle(var6 + this.h, this.f - (int) var8.getHeight(), (int) var8.getWidth(), (int) var8.getHeight()));
            }

            this.repaint();
        }

    }

    public void a(int var1) {
        if (var1 >= 0 && var1 <= 100) {
            this.e = var1;
        }

    }

    public void b() {
        this.lines.removeAllElements();
        this.d = this.c = 0;
        this.h = this.i = 0;
        this.e = 0;
        Dimension var1 = new Dimension(this.d, this.c);
        this.setPreferredSize(var1);
        this.setMinimumSize(var1);
        this.revalidate();
        this.repaint();
    }

    public Dimension getPreferredSize() {
        Dimension var1;
        if (!this.program.getExecutionOptions().isTraceEnabled()) {
            var1 = new Dimension(this.d, this.c);
        } else {
            var1 = new Dimension(this.g, this.f);
        }

        return var1;
    }
}
