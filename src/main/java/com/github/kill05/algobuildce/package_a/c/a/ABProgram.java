package com.github.kill05.algobuildce.package_a.c.a;

import com.github.kill05.algobuildce.json.JsonArray;
import com.github.kill05.algobuildce.json.JsonReader;
import com.github.kill05.algobuildce.package_a.c.b.ABInstructionBlock;
import com.github.kill05.algobuildce.package_a.c.b.p;
import com.github.kill05.algobuildce.package_a.c.b.q;
import com.github.kill05.algobuildce.json.JsonObject;
import com.github.kill05.algobuildce.package_a.f.ABFiles;
import com.github.kill05.algobuildce.package_a.f.ABSerializationException;
import com.github.kill05.algobuildce.package_a.f.ABProgramIO;
import com.github.kill05.algobuildce.package_a.f.ABUserData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
import javax.swing.JOptionPane;

public final class ABProgram {
    private Map<String, Object> a;
    private final Stack<ABExecutionFragment> fragmentStack;
    private final com.github.kill05.algobuildce.package_c.a c;
    private final AlgoBuild algobuild;
    private final Stack<Map<String, Object>> stack;
    private Vector<IProgramPanel> f = null;
    private ABExecutable g;
    private ABExecutable h;
    private String i;
    private boolean j;
    private final ViewOptions viewOptions;
    private final ExecutionOptions executionOptions;
    private String m = "";
    private int n = 0;
    private boolean o = false;
    private final SaveHistory saveHistory;

    public ABExecutionFragment getNextFragment() {
        return !this.fragmentStack.isEmpty() ? this.fragmentStack.peek() : null;
    }

    public ABProgram() {
        this.a = new TreeMap<>();
        this.fragmentStack = new Stack<>();
        this.c = new com.github.kill05.algobuildce.package_c.a();
        this.algobuild = new AlgoBuild();
        this.stack = new Stack<>();
        this.viewOptions = new ViewOptions();

        try {
            String var2 = "ViewOptions.abopt";
            File var3 = ABFiles.getABFolder();
            File var5 = new File(var3, var2);

            try (FileReader fileReader = new FileReader(var5)) {
                JsonReader jsonReader = new JsonReader(fileReader);
                JsonObject options = (new JsonObject(jsonReader)).getAsJsonObject("opt");

                if (options != null) {
                    this.viewOptions.deserializeOptions(options);
                }
            }
        } catch (IOException ignored) {
        }

        this.executionOptions = new ExecutionOptions();
        this.saveHistory = new SaveHistory();
    }

    public void reset() {
        this.fragmentStack.clear();
        this.stack.clear();
        this.a.clear();
        this.m = "";
        this.n = 0;
        this.o = false;
        this.saveHistory.clear();
    }

    public Map<String, Object> c() {
        return this.stack.peek();
    }

    public Stack<ABExecutionFragment> d() {
        return this.fragmentStack;
    }

    public com.github.kill05.algobuildce.package_c.a e() {
        return this.c;
    }

    public void f() {
        TreeMap<String, Object> map = new TreeMap<>();
        this.stack.push(map);
        this.a = map;
    }

    public void g() {
        if (!this.stack.isEmpty()) {
            this.stack.pop();
        }

        if (!this.stack.isEmpty()) {
            this.a = this.stack.firstElement();
        } else {
            this.a = null;
        }
    }

    public AlgoBuild getAlgoBuild() {
        return this.algobuild;
    }

    public void i() {
        String var1 = "";
        String var2 = "VARIABLES:\n";
        Map var3;
        Iterator var4;
        Entry var5;
        if ((var3 = this.c()) != null) {
            for (var4 = var3.entrySet().iterator(); var4.hasNext(); var2 = var2 + var5.getKey() + "=" + ((com.github.kill05.algobuildce.package_c.f) var5.getValue()).a() + "\n") {
                var5 = (Entry) var4.next();
                var1 = var1 + " | " + var5.getKey() + "=" + ((com.github.kill05.algobuildce.package_c.f) var5.getValue()).b();
            }
        }

        if (var1.length() > 0) {
            var1 = "    VAR: " + var1 + " |";
        }

        IProgramPanel var6;
        if (this.f != null && this.f.size() != 0) {
            for (var4 = this.f.iterator(); var4.hasNext(); var6.f(var2)) {
                var6 = (IProgramPanel) var4.next();
                if (var1.length() > 0) {
                    var6.d(var1);
                }
            }
        } else if (var1.length() > 0) {
            this.h(var1);
        }

    }

    public void a(String var1, int var2) {
        q var4 = this.algobuild.a(var1, var2);
        if (this.f != null) {

            for (IProgramPanel value : this.f) {
                value.a(var4);
            }

            var4.f();
        }

        this.update(true);
    }

    public void a(q var1) {
        var1 = this.algobuild.a(var1);
        if (this.f != null) {

            for (IProgramPanel value : this.f) {
                value.a(var1);
            }

            var1.f();
        }

        this.update(true);
    }

    public void a(String var1, q var2) {
        System.out.println("CODE VIEW - RENAME CODE:" + var1 + " to " + var2.j());
        q var3 = this.algobuild.a(var1);
        q var4 = this.algobuild.a(var2.j());
        if (var3 != null && var4 == null) {
            this.algobuild.c(var1);
            this.update(true);
            if (this.f != null) {

                for (IProgramPanel value : this.f) {
                    value.a(var1, var2);
                }
            }
        }

    }

    public q a(String var1) {
        return this.algobuild.a(var1);
    }

    public void b(String var1) {
        q var2 = this.algobuild.a(var1);
        this.algobuild.b(var1);
        this.update(true);
        if (this.f != null) {

            for (IProgramPanel value : this.f) {
                value.b(var2);
            }
        }

    }

    public void a(String var1, int var2, ABInstructionBlock var3) {
        this.l(var1).addInstruction(var3, var2);
        this.update(true);
    }

    public void c(String var1) {
        int var2;
        if ((var2 = var1.lastIndexOf(".")) >= 0) {
            String var3 = var1.substring(0, var2);
            ABExecutable var5 = this.l(var3);
            int var4 = Integer.parseInt(var1.substring(var2 + 1));
            var5.removeInstruction(var4);
        } else {
            this.b(var1);
        }

        this.update(true);
    }

    public ABInstructionBlock d(String var1) {
        int var2;
        if (var1 != null && !var1.isEmpty() && (var2 = var1.indexOf(46)) >= 0) {
            String var3 = var1.substring(0, var2);
            q var7 = this.a(var3);
            if ((var1 = var1.substring(var2 + 1)) != null) {
                String[] var4 = var1.split("[.]");
                String[] var6 = var4;
                if (var4.length == 1) {
                    return var7.getInstruction(Integer.parseInt(var4[0]));
                }

                ABInstructionBlock var5 = var7.getInstruction(Integer.parseInt(var4[0]));

                for (int var8 = 1; var8 < var6.length - 1; ++var8) {
                    var5 = var5.getInstruction(Integer.parseInt(var6[var8]));
                }

                return var5.getInstruction(Integer.parseInt(var6[var6.length - 1]));
            }
        }

        return null;
    }

    private ABExecutable l(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            return var1.indexOf(46) >= 0 ? this.d(var1) : this.a(var1);
        } else {
            return null;
        }
    }

    public ABExecutable j() {
        return this.g;
    }

    public void a(ABExecutable var1) {
        ABExecutable var2 = this.g;
        this.g = var1;
        if (var2 != null) {
            var2.a(false);
        }

        if (this.g != null) {
            this.g.a(false);
        }

    }

    public ABExecutable k() {
        return this.h;
    }

    public void b(ABExecutable var1) {
        this.h = var1;
    }

    public void a(IProgramPanel var1) {
        if (var1 != null) {
            if (this.f == null) {
                this.f = new Vector<>();
            }

            this.f.add(var1);
            var1.a(this);
        }

    }

    public void l() {
        ++this.n;
        if (this.f != null) {

            for (IProgramPanel value : this.f) {
                value.a(this.n);
            }
        }

    }

    public void m() {
        this.m.length();
        if (this.n >= 0) {
            --this.n;
            if (this.f != null) {

                for (IProgramPanel value : this.f) {
                    value.a(this.n);
                }
            }
        }

    }

    public String e(String var1) {
        String var2 = null;
        if (this.f != null && !this.f.isEmpty()) {

            for (IProgramPanel value : this.f) {
                if ((var2 = value.g(var1)) != null) {
                    return var2;
                }
            }
        }

        return null;
    }

    public void f(String var1) {
        if (this.f != null && !this.f.isEmpty()) {

            for (IProgramPanel var2 : this.f) {
                if (this.o) {
                    var2.a(this.m);
                }

                this.o = var1.endsWith("\n");
                var2.a(var1.replace("\n", "\n" + this.m));
            }

        } else {
            if (this.o) {
                System.out.print(this.m);
            }

            this.o = var1.endsWith("\n");
            System.out.print(var1.replace("\n", "\n" + this.m));
        }
    }

    public void n() {
        if (this.f != null && this.f.size() != 0) {

            for (IProgramPanel value : this.f) {
                value.b();
            }
        } else {
            System.out.println();
        }

        this.o = true;
    }

    public void g(String var1) {
        IProgramPanel var2;
        if (this.f != null && !this.f.isEmpty()) {
            for (Iterator<IProgramPanel> var3 = this.f.iterator(); var3.hasNext(); var2.b(var1)) {
                var2 = (IProgramPanel) var3.next();
                if (this.o) {
                    var2.a(this.m);
                }
            }
        } else {
            if (this.o) {
                System.out.print(this.m);
            }

            System.out.println(var1);
        }

        this.o = true;
    }

    public void h(String var1) {
        if (this.f != null && !this.f.isEmpty()) {

            for (IProgramPanel value : this.f) {
                value.c(var1);
            }

        } else {
            this.g(var1);
        }
    }

    public void i(String var1) {
        if (this.f != null && !this.f.isEmpty()) {

            for (IProgramPanel value : this.f) {
                value.e(var1);
            }

        } else {
            this.g(var1);
        }
    }

    private JsonObject serialize() {
        JsonObject var1 = new JsonObject();
        var1.put("abiid", "ABEENV");

        for (q object : this.algobuild.a()) {
            JsonObject var3 = object.b(true);
            var1.a("codepool", var3);
        }

        var1.put("viewOptions", this.viewOptions.serialize());
        var1.put("saveHistory", this.saveHistory.serialize());
        return var1;
    }

    public void saveProgram(String filePath) {
        ABProgramIO var2 = ABProgramIO.getInstance();
        String author = ABUserData.getInstance().getAuthUsername();
        if (author != null) {
            String serial = ABUserData.getInstance().getSerial();
            p var5 = this.algobuild.d();
            String sizeDescription = var5.a() + "/" + var5.b();
            File file = new File(filePath);
            this.saveHistory.setActualSessionSave(serial, author, file.getName(), sizeDescription);
        }

        JsonObject jsonObject = this.serialize();

        try {
            var2.writeProgram(filePath, jsonObject);
            this.j = false;
            this.i = filePath;

            for (IProgramPanel object : this.f) {
                object.b(this);
            }

        } catch (ABSerializationException var7) {
            JOptionPane.showMessageDialog(null, var7.getMessage());
        }
    }

    public void load(String filePath) {
        ABProgramIO programIO = ABProgramIO.getInstance();

        try {
            JsonObject programJson = programIO.readProgram(filePath);
            if (programJson == null) return;

            if (this.f != null) {
                for (IProgramPanel value : this.f) {
                    value.a();
                }
            }

            this.reset();
            this.algobuild.b();
            JsonObject var4 = programJson;
            ABProgram var3 = this;
            JsonObject saveHistoryJson = programJson.getAsJsonObject("saveHistory");
            this.saveHistory.clear();
            if (saveHistoryJson != null) {
                this.saveHistory.deserialize(saveHistoryJson);
            }

            if ((programJson = programJson.getAsJsonObject("viewOptions")) != null) {
                this.viewOptions.deserializeOptions(programJson);
            }

            JsonArray var10;
            if ((var10 = var4.getAsJsonArray("codepool")) != null) {
                for (int var12 = 0; var12 < var10.size(); ++var12) {
                    ABInstructionBlock var6;
                    (var6 = ABInstructionBlock.deserialize(saveHistoryJson = var10.getAsJsonObject(var12))).a(saveHistoryJson, true);
                    if (var6 instanceof q) {
                        var3.a((q) var6);
                    }
                }
            }

            this.j = false;
            this.i = filePath;

            for (IProgramPanel value : this.f) {
                value.b(this);
            }


        } catch (ABSerializationException var8) {
            JOptionPane.showMessageDialog(null, var8.getMessage());
        }

    }

    public String o() {
        return this.i;
    }

    public boolean p() {
        return this.j;
    }

    public void update(boolean var1) {
        this.j = var1;

        for (IProgramPanel value : this.f) {
            value.b(this);
        }

        if (var1) {

            for (q object : this.algobuild.a()) {
                object.a(true);
            }
        }

    }

    public ViewOptions getViewOptions() {
        return this.viewOptions;
    }

    public ExecutionOptions getExecutionOptions() {
        return this.executionOptions;
    }

    public String s() {
        return this.saveHistory.b();
    }
}
