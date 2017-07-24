package de.pfabulist.scancodeToolkitLicenses;

import de.pfabulist.roast.nio.Files_;
import de.pfabulist.roast.nio.Paths_;
import org.junit.Test;

import java.nio.file.Path;

import static de.pfabulist.roast.NonnullCheck._nn;
import static de.pfabulist.roast.lang.Strings_.getBytes;

/**
 * Copyright (c) 2006 - 2017, Stephan Pfab
 * SPDX-License-Identifier: BSD-2-Clause
 */

public class CreateDirListTest {

    @Test
    public void da() {
  //      Path dir = Paths_.get__( "" ).toAbsolutePath__().resolve_( "src/main/resources/licensedcode/data/licenses" );
        Path dir = Paths_.get__( "" ).toAbsolutePath__().resolve_( "../../licensedata/licensedcode/data/licenses" );
        Path targetDir = Paths_.get_( "target/classes/licensedcode/data" );
        Path targetDirfull = Paths_.get_( "target/classes/licensedcode/data/licenses" );
        Path targetFile = targetDir.resolve( "licenses.list" );

        if ( Files_.exists( targetFile )) {
            return;
        }

        Files_.createDirectories( targetDirfull );

        StringBuilder list = new StringBuilder();
        Files_.list_( dir ).forEach( d -> {
            Path filename = d.getFileName();
            Files_.copy( d, targetDirfull.resolve( filename ) );
            list.append( filename.toString() + "\n" ); });


     //   Files_.createDirectories( targetDir );
        Files_.write( targetFile, getBytes( list.toString() ) );

    }
}
