/*
 * JaLingo, http://jalingo.sourceforge.net/
 *
 * Copyright (c) 2002-2006 Oleksandr Shyshko
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ja.lingo.engine.searchindex;

class NodeOptimizer {
    public void optimize( IMutableNode node ) {
        for ( int i = 0; i < node.childrenCount(); i++ ) {
            Node childNode = (Node) node.getChild( i );

            if ( !childNode.isLeaf() ) {
                optimize( childNode );
            }

            if ( childNode.isLeaf() ) {
                if ( node.childrenCount() == 1 && node.getValue() == childNode.getValue() )
                    node.removeChild( childNode );
            }
        }
    }
}
