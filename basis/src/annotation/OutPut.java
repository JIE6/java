package annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

/**
 * 编译时处理注解
 *
 * APT (Annotation Processing Tool) 是一种注解处理工具，它对源代码文件进行检测，并找出源文件所包含的注解信息，然后针对注解信息进行额外的处理。
 *
 * 使用APT 工具处理注解时可以根据源文件中的注解生成额外的源文件和其他的文件(文件的具体内容由注解处理器的编写者决定)， APT 还会编译生成的源代码文件和原来的源文件，
 * 将它们一起生成class 文件。
 *
 * 使用APT 的主要目的是简化开发者的工作量，因为APT 可以在编译程序源代码的同时生成一些附属文件( 比如源文件、类文件、程序发布描述文件等)，这些附属文件的内容也都与源代码相关。
 * 换句话说，使用APT 可以代替传统的对代码信息和附属文件的维护工作。
 *
 * Java 提供的javac.exe 工具有一个-processor 选项，该选项可指定一个注解处理器，如果在编译Java源文件时通过该选项指定了注解处理器，
 * 那么这个注解处理器将会在编译时提取并处理Java 源文件中的注解。
 *
 * 每个注解处理器都需要实现javax.annotation.processing 包下的Processor 接口。不过实现该接口必须实现它里面所有的方法， 因此通常会采用继承AbstractProcessor 的方式来实现注解处理器。
 * 一个注解处理器可以处理一种或者多种注解类型。
 *
 * 为了示范使用APT 根据源文件中的注解来生成额外的文件，将定义 Persistent,Id,Property 3 种注解类型，分别用于修饰持久化类、标识属性和普通成员属性。
 *
 * @author JIE
 */

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Persistent", "Id", "Property"})
public class OutPut extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        //定义一个文件输出流， 用于生成额外的文件
        PrintStream ps = null ;
        try {
            // 遍历每个被@Persistent 修饰的class 文件
            for (Element element : roundEnv.getElementsAnnotatedWith(Persistent.class)) {
                // 获取正在处理的类名
                Name simpleName = element.getSimpleName();
                // 获取类定义前的@Persistent 注解
                Persistent persistent = element.getAnnotation(Persistent.class);
                ps = new PrintStream(new FileOutputStream(simpleName+".txt"));
                // 执行输出
                ps.println("name="+element);
                // 输出persistent 的table ()的值
                ps.println("table="+persistent.table());
                for (Element enclosedElement : element.getEnclosedElements()) {
                    // 只处理成员变量上的注解
                    if (enclosedElement.getKind() == ElementKind.FIELD) {
                        // 获取成员变量定义前的@Id 注解
                        Id id = enclosedElement.getAnnotation(Id.class);
                        if (id != null) {
                            ps.println("id_column="+id.column());
                            ps.println("id_type="+id.type());
                            ps.println("id_generator="+id.generator());
                        }
                        Property property = enclosedElement.getAnnotation(Property.class);
                        if (property != null) {
                            ps.println("property_column="+property.column());
                            ps.println("property_type="+property.type());
                        }
                    }
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
