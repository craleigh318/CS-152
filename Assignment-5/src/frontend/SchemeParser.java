/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;
import intermediate.IntermediateCode;
import intermediate.Node;
/**
 *
 * @author BrandonRossi
 */
public class SchemeParser
{

   IntermediateCode inter_Code;
   public SchemeParser(IntermediateCode intCode)
   {
       inter_Code = intCode;

   }

   public void setUpTree()
   {
       Node temp = buildTree();
       inter_Code.getTree().setroot(temp);
   }

   private Node buildTree()
   {
       return null;
   }

}
